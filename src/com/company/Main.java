package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    final private static double SELF_RELIEF_MAX = 9000;
    final private static double DISALBED_INDIVIDUAL_RELIEF_MAX = 6000;
    final private static double SPOUSE_RELIEF_MAX = 4000;
    final private static double DISABLED_SPOUSE_MAX = 3500;
    final private static double SOCSO_RELIEF_MAX = 250;
    final private static double EPF_RELIEF_MAX = 4000;
    final private static double LIFE_INSURANCE_PREMIUMS_MAX = 3000;
    final private static double PRIVATE_RETIREMENT_SCHEME_DEFERRED_ANNUITY_MAX = 3000;
    final private static double MEDICAL_EDUCATION_INSURANCE_PREMIUM_MAX = 3000;
    final private static double LIFESTYLE_EXPENSES_MAX = 2500;
    final private static double EDUCATION_FEES_FOR_SELF_MAX = 7000;
    final private static double RELIEF_PER_CHILDREN = 2000;
    final private static double RELIEF_PER_CHILDREN_IN_HIGHER_EDUACTION = 8000;
    final private static double TOTAL_SSPN_SAVINGS_MAX = 8000;
    final private static double PURCHASE_OF_SUPPORTING_EQUIPMENT_MAX = 6000;
    final private static double CHILD_CARE_AND_KINDERGARTEN_FEES_MAX = 2000;
    final private static double FAMILY_MEDICAL_EXAMINATIONS_AND_EXPENSES_MAX = 6000;
    final private static double PARENTAL_CARE_MEDICAL_EXPENSES_MAX = 5000;
    final private static double PARENTAL_CARE_LIVING_FEE_MAX = 3000;
    final private static double RELIEF_PER_DISABLED_CHILDREN = 6000;
    final private static double RELIEF_PER_DISABLED_CHILDREN_IN_HIGHER_EDUACTION = 14000;
    final private static double PURCHASE_OF_BREASTFEEDING_EQUIPMENT_MAX = 1000;
    final private static double LOWEST_CHARGEABLE_LINE = 35000;
    final private static double REBATE_TO_TAXPAYER_UNDER_BASELINE_MAX = 400;
    final private static double ADDITION_REBATE_TO_SPOUSE_MAX = 400;
    final private static double[][] SOCSO_SCHEME = {{30, 0.1}, {50, 0.3}, {70, 0.3}, {100, 0.4}, {140, 0.6}, {200, 0.85}, {300, 1.25}, {400, 1.75}, {500, 2.25}, {600, 2.75}, {700, 3.25},
            {700, 3.25}, {800, 3.75}, {900, 4.75}, {1000, 4.75}, {1100, 5.25}, {1200, 5.75}, {1300, 6.25}, {1400, 6.75}, {1500, 7.25}, {1600, 7.75}, {1700, 8.25}, {1800, 8.75}, {1900, 9.25},
            {2000, 9.75}, {2100, 10.25}, {2200, 10.75}, {2300, 11.25}, {2400, 11.75}, {2500, 12.25}, {2600, 12.75}, {2700, 13.25}, {2800, 13.75}, {2900, 14.25}, {3000, 14.75}, {3100, 15.25},
            {3200, 15.75}, {3300, 16.25}, {3400, 16.75}, {3500, 17.25}, {3600, 17.75}, {3700, 18.25}, {3800, 18.75}, {3900, 19.25}, {4000, 19.75}};
    final private static double[][] TAX_RATE = {{5000, 1, 50}, {10000, 1, 150}, {20000, 3, 600}, {35000, 8, 1800}, {50000, 14, 4600}, {70000, 21, 10900}
            , {100000, 24, 22900}, {150000, 24, 46900}, {250000, 24.5, 83650}, {400000, 25, 133650}, {600000, 26, 237650}, {1000000, 28, 517650}, {2000000, 30, 0}};
    //if your chargeable income is 12000, mean (12000-10000)*1/100+50,
    // first number in the child array is the starting point of tax class
    //second number in the child array is the tax rate with the tax class
    //third number in the child array is the gross tax, mean if excess the tax class, at least need to pay this amount no need calculate again.
    private static double salary = 0;
    private static double bonus = 0;
    private static double other_income = 0;
    private static double disabled_individual = 0;
    private static double spouse_relief = 0;
    private static double disabled_spouse = 0;
    private static double socso = 0;
    private static double socso_relief = 0;
    private static double epf = 0;
    private static double epf_rate = 0;
    private static double epf_relief = 0;
    private static double life_insurance_premiums = 0;
    private static double private_retirement_scheme_deferred_annuity = 0;
    private static double medical_education_insurance_premium = 0;
    //    family
    private static double lifestyle_expenses = 0;
    private static double education_fees_for_self = 0;
    private static double total_number_of_children = 0;
    private static double number_of_children_in_higher_education = 0;
    private static double total_sspn_savings = 0;
    private static double purchase_of_supporting_equipment = 0;
    private static double child_care_and_kindergarten_fees = 0;
    //    medical
    private static double family_medical_examinations_and_expenses = 0;
    private static double parental_care_medical_expenses = 0;
    private static double parental_care_living_fee = 0;
    private static double disabled_children = 0;
    private static double disalbed_children_higher_education = 0;
    private static double purchase_of_breastfeeding_equipment = 0;
    private static double total_ananual_income = 0;
    private static double total_tax_relief = 0;
    private static double chargeable_income = 0;
    private static double total_tax_payment = 0;

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your employment salary per month");
        salary = scanner.nextDouble();
        System.out.println("What is your employment bonus ?");
        bonus = scanner.nextDouble();
        System.out.println("What is your other income for this year?");
        other_income = scanner.nextDouble();
        System.out.println("What is your EPF rate for this year?");
        epf_rate = scanner.nextDouble();
        System.out.println("Do you have any disability? (Yes =1, No = 0)");
        disabled_individual = scanner.nextDouble();
        System.out.println("Do you have any spouse no working or elects for combined assessment for tax relief? (Yes =1, No = 0)");
        spouse_relief = scanner.nextDouble();
        System.out.println("Does your spouse have any disability? (Yes =1, No = 0)");
        disabled_spouse = scanner.nextDouble();
        System.out.println("Claim Life Insurance Premiums relief(Maximum RM 3000)");
        life_insurance_premiums = scanner.nextDouble();
        while (life_insurance_premiums > LIFE_INSURANCE_PREMIUMS_MAX) {
            System.out.println("The maximum value for Life Insurance Premiums relief is RM 3000");
            life_insurance_premiums = scanner.nextDouble();
        }
        System.out.println("Claim Private Retirement Scheme & Deferred Annuity (PRS)relief (Maximum RM 3000)");
        private_retirement_scheme_deferred_annuity = scanner.nextDouble();
        while (private_retirement_scheme_deferred_annuity > PRIVATE_RETIREMENT_SCHEME_DEFERRED_ANNUITY_MAX) {
            System.out.println("The maximum value for Private Retirement Scheme & Deferred Annuity (PRS) relief is RM 3000");
            private_retirement_scheme_deferred_annuity = scanner.nextDouble();
        }
        System.out.println("Claim Medical or Education Insurance Premiums (Maximum RM 3000) relief");
        medical_education_insurance_premium = scanner.nextDouble();
        while (medical_education_insurance_premium > MEDICAL_EDUCATION_INSURANCE_PREMIUM_MAX) {
            System.out.println("The maximum value for Medical or Education Insurance Premiums relief is RM 3000");
            medical_education_insurance_premium = scanner.nextDouble();
        }
        System.out.println("Claim Lifestyle Expenses relief (Maximum RM 2500)");
        lifestyle_expenses = scanner.nextDouble();
        while (lifestyle_expenses > LIFESTYLE_EXPENSES_MAX) {
            System.out.println("The maximum value for Lifestyle Expenses relief is RM 2500");
            lifestyle_expenses = scanner.nextDouble();
        }
        System.out.println("Claim Education Fees for Self relief (Maximum 7000)");
        education_fees_for_self = scanner.nextDouble();
        while (education_fees_for_self > EDUCATION_FEES_FOR_SELF_MAX) {
            System.out.println("The maximum value for Education Fees for Self relief is RM 7000");
            education_fees_for_self = scanner.nextDouble();
        }
        System.out.println("Total number of Children include all the children below 18. For children above 18, only include if they are not married and still studying full time.");
        total_number_of_children = scanner.nextDouble();
        System.out.println("Total number of Children include children above 18 are not married and still studying full time.");
        number_of_children_in_higher_education = scanner.nextDouble();
        System.out.println("Claim SSPN Savings relief (Maximum RM 8000):");
        total_sspn_savings = scanner.nextDouble();
        while (total_sspn_savings > TOTAL_SSPN_SAVINGS_MAX) {
            System.out.println("The maximum value for SSPN Savings relief is RM 8000");
            total_sspn_savings = scanner.nextDouble();
        }
        System.out.println("Claim Purchase of Supporting Equipment relief (Maximum RM 6000)");
        purchase_of_supporting_equipment = scanner.nextDouble();
        while (purchase_of_supporting_equipment > PURCHASE_OF_SUPPORTING_EQUIPMENT_MAX) {
            System.out.println("The maximum value for Purchase of Supporting Equipment relief is RM 6000");
            purchase_of_supporting_equipment = scanner.nextDouble();
        }
        System.out.println("Claim Child Care and Kindergarten Fees relief (Maximum RM 2000)");
        child_care_and_kindergarten_fees = scanner.nextDouble();
        while (child_care_and_kindergarten_fees > CHILD_CARE_AND_KINDERGARTEN_FEES_MAX) {
            System.out.println("The maximum value for Child Care and Kindergarten Fees relief is RM 2000");
            child_care_and_kindergarten_fees = scanner.nextDouble();
        }
        System.out.println("Claim Family Medical Examinations and Expenses relief (Maximum RM 6000)");
        family_medical_examinations_and_expenses = scanner.nextDouble();
        while (family_medical_examinations_and_expenses > FAMILY_MEDICAL_EXAMINATIONS_AND_EXPENSES_MAX) {
            System.out.println("The maximum value for Family Medical Examinations and Expenses relief is RM 6000");
            family_medical_examinations_and_expenses = scanner.nextDouble();
        }
        System.out.println("Claim Parental Care Medical Expenses relief (Maximum RM 5000)");
        parental_care_medical_expenses = scanner.nextDouble();
        while (parental_care_medical_expenses > PARENTAL_CARE_MEDICAL_EXPENSES_MAX) {
            System.out.println("The maximum value for Parental Care Medical Expenses  and Expenses relief is RM 5000");
            parental_care_medical_expenses = scanner.nextDouble();
        }
        if (parental_care_medical_expenses!=0){
            System.out.println("Claim Parental Care Living Fee relief (Maximum RM 5000)");
            parental_care_living_fee = scanner.nextDouble();
            while (parental_care_living_fee > PARENTAL_CARE_LIVING_FEE_MAX) {
                System.out.println("The maximum value for Parental Care Living Fee relief is RM 5000");
                parental_care_living_fee = scanner.nextDouble();
            }
        }
        System.out.println("No of Disabled Children:");
        disabled_children = scanner.nextDouble();
        System.out.println("No of Disabled Children in Higher Education");
        disalbed_children_higher_education = scanner.nextDouble();
        System.out.println("Claim Purchase of Breastfeeding Equipment relief (Maximum RM 5000)");
        parental_care_living_fee = scanner.nextDouble();
        while (purchase_of_breastfeeding_equipment > PURCHASE_OF_BREASTFEEDING_EQUIPMENT_MAX) {
            System.out.println("The maximum value for Purchase of Breastfeeding Equipment relief is RM 5000");
            purchase_of_breastfeeding_equipment = scanner.nextDouble();
        }
        total_ananual_income= calculateNetIncome();
        System.out.println(total_ananual_income);
        System.out.println(epf);
        System.out.println(socso);
        total_tax_relief=calculateTotalRelief();
        System.out.println(total_tax_relief);
        total_tax_payment=calculateAnnalTaxPay();
        System.out.println(total_tax_payment);

    }

    public static double calculateNetIncome() {
        epf = salary * (epf_rate / 100);
        if (epf*12>=4000){
            epf_relief=4000;
        }else {
            epf_relief=epf*12;
        }
        if (salary >= SOCSO_SCHEME[SOCSO_SCHEME.length - 1][0]) {
            socso = SOCSO_SCHEME[SOCSO_SCHEME.length - 1][1];
        } else {
            for (int i = SOCSO_SCHEME.length - 1; i >= 0; i--) {
                if (salary < SOCSO_SCHEME[i][0] && salary > SOCSO_SCHEME[i - 1][0] && i != 0) {
                    socso = SOCSO_SCHEME[i][0];
                } else if (i == 0 && salary < SOCSO_SCHEME[0][0]) {
                    socso = SOCSO_SCHEME[0][1];
                }
            }
        }
        if (socso*12>250){
            socso_relief=250;
        }else {
            socso_relief=socso*12;
        }
        return (salary - epf - socso) * 12+other_income;
    }

    public static double calculateTotalRelief() {
        double totalRelief =
                SELF_RELIEF_MAX + disabled_individual*DISALBED_INDIVIDUAL_RELIEF_MAX +spouse_relief*SPOUSE_RELIEF_MAX+disabled_spouse*DISABLED_SPOUSE_MAX+socso_relief+epf_relief+life_insurance_premiums+private_retirement_scheme_deferred_annuity+
                medical_education_insurance_premium+lifestyle_expenses+education_fees_for_self+total_number_of_children*RELIEF_PER_CHILDREN+number_of_children_in_higher_education*RELIEF_PER_CHILDREN_IN_HIGHER_EDUACTION+total_sspn_savings+purchase_of_supporting_equipment+
                child_care_and_kindergarten_fees+family_medical_examinations_and_expenses+parental_care_medical_expenses+parental_care_living_fee+disabled_children*RELIEF_PER_DISABLED_CHILDREN+disalbed_children_higher_education*RELIEF_PER_DISABLED_CHILDREN_IN_HIGHER_EDUACTION+
                purchase_of_breastfeeding_equipment;
        return totalRelief;

    }
    public static double calculateAnnalTaxPay(){
        chargeable_income=total_ananual_income-total_tax_relief;
        System.out.println(chargeable_income);
        double totalTax=0;
        int pointer = -1;
        if (chargeable_income>0){

            for (int i=0;i<TAX_RATE.length;i++){
                if(chargeable_income>=TAX_RATE[i][0]){
                    pointer=i;
                }
            }
            if (pointer ==0){
                totalTax=(chargeable_income-TAX_RATE[pointer][0])*TAX_RATE[pointer][1]/100;
            }else if(pointer>0){
                totalTax=(chargeable_income-TAX_RATE[pointer][0])*TAX_RATE[pointer][1]/100+TAX_RATE[pointer-1][2];
            }
            if (chargeable_income<LOWEST_CHARGEABLE_LINE){
                totalTax=totalTax-REBATE_TO_TAXPAYER_UNDER_BASELINE_MAX-spouse_relief*ADDITION_REBATE_TO_SPOUSE_MAX;
            }
            if (totalTax>0){
                return totalTax;
            }else {
                return 0;
            }
        }else {
            return 0;
        }
    }
}


