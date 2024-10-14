package beratbadan;

import user.user;

public final class BeratBadan {
    private user user;
    private double tinggiBadan;
    private double beratBadan;

    public BeratBadan(user user, double tinggiBadan, double beratBadan) {
        this.user = user;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    // Getter untuk user
    public user getUser() {
        return user;
    }

    // Getter dan Setter untuk encapsulation
    public double getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(double tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(double beratBadan) {
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
