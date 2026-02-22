public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        switch (chifoumiAction) {
            case ROCK:
                return ChifoumiAction.SCISSOR;
            case PIPER:
                return ChifoumiAction.ROCK;
            default:
                return ChifoumiAction.PIPER;
        }
    }
}