package Módulos.Produto;



import dataFactory.ProdutoDataFactory;
import dataFactory.UsuárioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Teste de API Rest do módulo Produto")
public class ProdutoTest {
    private String token;

    @BeforeEach
    public void beforeEach() {
        //configurando os dados da Api Rest da lojinha
        baseURI = "http://165.227.93.41";
        //port = 8080;
        basePath = "/lojinha";


        //obter o token do usuário admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuárioDataFactory.criarUsuarioAdministrador())
                .when()
                .post("/v2/login")
                .then()
                .extract()
                .path("data.token");
    }


    @Test
    @DisplayName("Validar que o valor do produto igual a 0.00 não é permitido")

    public void testeValidarLimitesZeradoProibidosValorProduto() {

        //tentar inserir um produto com valor 0.00 e validar que a mensagem de erro foi apresentada e ou status code retornado foi 422


        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComValorIgualA(0.00))
                .when()
                .post("/v2/produtos")
                .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);
    }

    @Test
    @DisplayName("Validar que o valor do produto igual a 7000.01 não é permitido")

    public void testeValidarLimitesMaior7MilProibidosValorProduto() {

        //tentar inserir um produto com valor 7000.01 e validar que a mensagem de erro foi apresentada e ou status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComValorIgualA(7000.01))
                .when()
                .post("/v2/produtos")
                .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);


    }
}
