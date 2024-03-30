package src.aaa;

public class Rational {
    int numerator=1;
    int denominator=1;

    void setNumerator(int a){
        int c=f(Math.abs(a),denominator);
        numerator=a/c;
        denominator=denominator/c;
        if (numerator<0 && denominator<0){
            numerator=-numerator;
            denominator=-denominator;
        }
    }

    void setDenominator(int b){
        int c=f(numerator,Math.abs(b));
        numerator/=c;
        denominator=b/c;
        if (numerator<0 && denominator<0){
            numerator=-numerator;
            denominator=-denominator;
        }
    }

    int getNumerator(){
        return numerator;
    }

    int getDenominator(){
        return denominator;
    }

    int f(int a,int b){
        if (a==0)return 1;
        if (a<b){
            int c=a;
            a=b;
            b=c;
        }
        int r=a%b;
        while (r!=0){
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }

    Rational add(Rational r){
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*b+denominator*a;
        int newDenominator=denominator*b;
        Rational result=new Rational();
        result.setNumerator(newNumerator);
        result.setDenominator(newDenominator);
        return result;
    }

    Rational sub(Rational r){
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*b-denominator*a;
        int newDenominator=denominator*b;
        Rational result=new Rational();
        result.setNumerator(newNumerator);
        result.setDenominator(newDenominator);
        return result;
    }

    Rational muti(Rational r){
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*a;
        int newDenominator=denominator*b;
        Rational result=new Rational();
        result.setNumerator(newNumerator);
        result.setDenominator(newDenominator);
        return result;
    }

    Rational div(Rational r){
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*b;
        int newDenominator=denominator*a;
        Rational result=new Rational();
        result.setNumerator(newNumerator);
        result.setDenominator(newDenominator);
        return result;
    }
}
