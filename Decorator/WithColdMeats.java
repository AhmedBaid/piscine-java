public class WithColdMeats extends RacletteDecorator {

    public WithColdMeats(Raclette raclette) {
        super(raclette);
    }

    @Override
    public int getCalories() {
        return 350 + raclette.getCalories();
    }

    @Override
    public String getIngredients() {
        return raclette.getIngredients() + ", charcuterie";
    }

    @Override
    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}