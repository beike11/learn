package TestEnum;

/**
 * @author stevenw
 * @date 2018/7/25
 */
public enum Days {
    ONE("1"),
    TWO("2");
    private String key;
    private Days(String key){
        this.key=key;
    }

    public String getKey() {
        return key;
    }
}
