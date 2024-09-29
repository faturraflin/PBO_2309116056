package beratbadan;

import user.User;

public class BeratBadan {
    public User user;
    public double tinggiBadan;
    public double beratBadan;

    public BeratBadan(User user, double tinggiBadan, double beratBadan) {
        this.user = user;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    public double hitungBMI() {
        return beratBadan / (tinggiBadan * tinggiBadan);
    }

    public void tampilkanStatusBMI() {
        double bmi = hitungBMI();
        System.out.println("BMI " + user.getNama() + ": " + bmi);
        if (bmi < 18.5) {
            System.out.println("Status: Kekurangan berat badan");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("Status: Kelebihan berat badan");
        } else {
            System.out.println("Status: Obesitas");
        }
    }
}
