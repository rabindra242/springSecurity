package com.example.reactspringboot.utill;

public class EmailUtill {

    public static String getEmailMessage(String name,String host,String token){
        return "Hello"+name+ ",\n\n Your new account has been created please click the line below.\n\n"
                +getVerificationUtl(host,token)+"\n \n The Suport team";
    }

    private static String getVerificationUtl(String host, String token) {

        return host+"/verify/account?token="+token;
    }

    public static String getResetPasswordMessage(String name,String host,String token){
        return "Hello"+name+ ",\n\n Your new account has been created please click the line below.\n\n"
                +getVerificationUtl(host,token)+"\n \n The Suport team";
    }
}
