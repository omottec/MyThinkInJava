package storyCharacters;

/**
 * Created by qinbingbing on 2/5/16.
 */
public class StoryCharacter {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
