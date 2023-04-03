package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectBase {

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoConfirmarCadastro;
    private MobileElement erroMensagem;
    private final By erroId;
    private final By campoNomeId;
    private final By campoSenhaId;
    private final By campoConfirmacaoId;
    private final By botaoCadastrarId;

    protected CadastroPageObject(AppiumDriver driver) {
        super(driver);
        erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeId = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmacaoId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrarId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos(){
        campoNome = (MobileElement) driver.findElement(campoNomeId);
        campoSenha = (MobileElement) driver.findElement(campoSenhaId);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmacaoId);
        botaoConfirmarCadastro = (MobileElement) driver.findElement(botaoCadastrarId);
    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao){
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

    public LoginPageObject Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoConfirmarCadastro.click();
        return new LoginPageObject(driver);
    }

    public String ErroMensagem(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroId));

        erroMensagem = (MobileElement) driver.findElement(erroId);
        return erroMensagem.getText();
    }
}
