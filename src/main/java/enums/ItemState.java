package enums;

public enum ItemState {
    CORRECT {
        public String toString() {
            return "в порядке";
        }
    },
    BROKEN {
        public String toString() {
            return "сломано";
        }
    }
}
