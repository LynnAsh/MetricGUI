public class Converter extends GUI{
    public static String calculate() {
        double num = 0;
        double inputNum = Double.parseDouble(input.getText());
        String metricS = metric.getValue();

        if (metricS.equals("Kilometers")) {
            num = inputNum * 0.6213711922;
        } else if (metricS.equals("Meters")){
            num = (inputNum / 1000) * 0.6213711922;
        } else if (metricS.equals("Kilograms")) {
            num = inputNum * 2.2046226218;
        } else if (metricS.equals("Grams")) {
            num = (inputNum / 1000) * 2.2046226218;
        } else if (metricS.equals("Celsius")){
            num = (inputNum * 1.8) + 32;
        }

        String output = String.valueOf(num);
        return output;
    }
}
