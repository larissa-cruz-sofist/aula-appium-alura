package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import java.net.MalformedURLException;
import static org.junit.Assert.assertTrue;

public class FeatureCadastro {
    @Test
    public void nao_consigo_cadastrar_usuarios_que_as_senhas_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaCadastro();

        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Bugan", "123","456");


        Assert.assertEquals("Senhas não conferem", telaCadastro.ErroMensagem());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaDeCadastro = telaLogin.IrParaTelaCadastro();

        telaDeCadastro.BuscarElementos();
        telaLogin = telaDeCadastro.Cadastrar("Bugan", "123","123");
        telaLogin.BuscarElementos();

    }

}

