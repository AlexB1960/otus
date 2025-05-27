package homework2.data;

public enum ColorData {

    WHITE("Белый"),
    BLACK("Черный"),
    GREY("Серый"),
    RED("Рыжий");

    private String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
