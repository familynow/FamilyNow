package Pages;

public abstract class BasePage<TElement, TOperation> {
	public abstract  TElement Elements();
    public abstract  TOperation Operations(); 
}
