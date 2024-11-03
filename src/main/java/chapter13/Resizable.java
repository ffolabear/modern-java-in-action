package chapter13;

public interface Resizable extends Drawable {

    int getWidth();

    int getHeight();

    void setWidth(int width);

    void setHeight(int height);

    void setAbsoluteSize(int width, int height);

    default void setRelativeSize(int wFact0r, int hFactor) {
        setAbsoluteSize(getWidth() / wFact0r, getHeight()/ hFactor);
    };

}

