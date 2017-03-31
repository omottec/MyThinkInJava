package storyCharacters;

import net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by qinbingbing on 2/5/16.
 */
public class StoryCharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {
    private Class[] types = { DarthVader.class, JabbaTheHut.class,
            LukeSkywalker.class, Yoda.class };
    private static Random rand = new Random();

    public StoryCharacterGenerator() {
    }

    private int size;

    public StoryCharacterGenerator(int size) {
        this.size = size;
    }

    @Override
    public StoryCharacter next() {
        try {
            return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new StoryCharacterIterator();
    }

    class StoryCharacterIterator implements Iterator<StoryCharacter> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public StoryCharacter next() {
            count--;
            return StoryCharacterGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        StoryCharacterGenerator gen = new StoryCharacterGenerator();
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for (StoryCharacter s : new StoryCharacterGenerator(5))
            System.out.println(s);
    }
}
