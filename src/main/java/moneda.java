import com.google.gson.annotations.SerializedName;

public class moneda {
    @SerializedName("base_code")
    private double monedaUno;
    @SerializedName("target_code")
    private double monedaDos;
    @SerializedName("conversion_rate")
    private double numeralConversionRate;

    public double getMonedaUno() {
        return monedaUno;
    }

    public void setMonedaUno(double monedaUno) {
        this.monedaUno = monedaUno;
    }

    public double getMonedaDos() {
        return monedaDos;
    }

    public void setMonedaDos(double monedaDos) {
        this.monedaDos = monedaDos;
    }

    public double getNumeralConversionRate() {
        return numeralConversionRate;
    }

    public void setNumeralConversionRate(double numeralConversionRate) {
        this.numeralConversionRate = numeralConversionRate;
    }
}