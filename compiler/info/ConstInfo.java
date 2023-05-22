package compiler.info;

public class ConstInfo {

    private final boolean isConst;
    private final int value;

    public ConstInfo(boolean isConst, int value) {
        this.isConst = isConst;
        this.value = value;
    }

    public boolean isConst() {
        return isConst;
    }

    public int getValue() {
        return value;
    }

}