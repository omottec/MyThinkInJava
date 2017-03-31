package innerclasses.ex6Base;

import innerclasses.ex6Interface.Ex6Interface;

/**
 * Created by qinbingbing on 1/28/16.
 */
public class Ex6Base {
    protected class Ex6BaseInner implements Ex6Interface {
        public Ex6BaseInner() {
        }

        @Override
        public String say() {
            return "Hi";
        }
    }
}
