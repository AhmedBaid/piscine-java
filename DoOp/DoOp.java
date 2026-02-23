public class DoOp {
    public static String operate(String[] args) {
        if (args.length != 3) {
            return "Error";
        }
        int nb1 = Integer.parseInt(args[0]);
        int nb2 = Integer.parseInt(args[2]);
        String operation = args[1];
        String res = "";
        switch (operation) {
            case "+":
                res = String.valueOf((nb1 + nb2));
                break;
            case "-":
                res = String.valueOf((nb1 - nb2));
                break;
            case "*":
                res = String.valueOf((nb1 * nb2));
                break;
            case "/":
                if (nb2 == 0) {
                    return "Error";
                }
                res = String.valueOf((nb1 / nb2));
                break;
            case "%":
                if (nb2 == 0) {
                    return "Error";
                }
                res = String.valueOf((nb1 % nb2));
                break;
            default:
                return "Error";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(DoOp.operate(new String[] { "1", "+", "2" }));
        System.out.println(DoOp.operate(new String[] { "1", "-", "1" }));
        System.out.println(DoOp.operate(new String[] { "1", "%", "0" }));
        System.out.println(DoOp.operate(args));
    }
}