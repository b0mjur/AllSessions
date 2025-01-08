package Session8;

public class StaticEx {
    static class Config {
        public static int defaultValue;

        static {
            defaultValue = 100;
        };
        public static int getDefaultValue() {
            return defaultValue;
        }

    }
    public static void main(String[] args) {
        Config c = new Config();
        System.out.println(c.getDefaultValue());
    }
}
