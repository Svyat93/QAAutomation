package data;

import org.testng.annotations.DataProvider;
import utility.ConfigReader;

public class DataProviders {

    @DataProvider(name = "authorizationValidData")
    public Object[][] positiveAuthorizationTestData(){
     return new Object[][]{
             {"93userqa@gmail.com","qauser1993"}
     };
    }

    @DataProvider(name = "authorizationInvalidData")
    public Object[][] negativeAuthorizationTestData(){
        return new Object[][]{
                {"93userqagmail.com","S240993"},
        };
    }

    @DataProvider(name = "authorizationIncorrectPassword")
    public Object[][] authorizationIncorrectPassword(){
        return new Object[][]{
                {"93userqa@gmail.com","S240993"},
        };
    }


    @DataProvider(name = "registrationInvalidData")
    public Object[][] negativeRegistrationTestData(){
        return new Object[][]{
                {"Svyat","Naboka","userqa@gmail.com","S0993"},
        };
    }

    @DataProvider(name = "signInFacebookValidData")
    public Object[][] positiveSignInFacebookTestData(){
        return new Object[][]{
                {"93userqa@gmail.com","user1993"}
        };
    }

    @DataProvider(name = "signInFacebookInvalidData")
    public Object[][] negativeSignInFacebookTestData(){
        return new Object[][]{
                {"93userqa@gmail.com","qauser1993"}
        };
    }

    @DataProvider(name = "resetPasswordValidData")
    public Object[][] positiveResetPasswordTestData(){
        return new Object[][]{
                {"93userqa@gmail.com"}

        };
    }

    @DataProvider(name = "resetPasswordInvalidData")
    public Object[][] negativeResetPasswordTestData(){
        return new Object[][]{
                {"93userqagmail.com"},
        };
    }

    @DataProvider(name = "invalidChangePasswordData")
    public Object[][] negativeChangePasswordTestData(){
        return new Object[][]{
                {"qa","qauser1993"},
        };
    }

    @DataProvider(name = "addEmailData")
    public Object[][] positiveAddEmailTestData(){
        return new Object[][]{
                {"93userqa@gmail.com"},
        };
    }

}
