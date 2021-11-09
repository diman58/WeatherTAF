package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonConditions {
    public static final String moscow = "Moscow";
    public static final String penza = "Penza";
    public static final String gismeteo = "https://www.gismeteo.ru/";
    public static final String yandexPogoda = "https://yandex.ru/pogoda/";
    public static int moscowsGismeteoNowTempValue;
    public static int moscowsYandexNowTempValue;
    public static int gismeteoNowTempValue;
    public static int yandexNowTempValue;
    public static String grinferURI = "https://grinfer.com/api";
    public static String grinferPATH = "/content/profiles/personal";
    public static String cookies = "_ga=GA1.2.657637533.1632399745; _ym_d=1632399746; _ym_uid=1632399746636941441; _fbp=fb.1.1632404580772.1273016858; G_ENABLED_IDPS=google; _gac_UA-144858230-1=1.1633094496.EAIaIQobChMIl6qAiKep8wIVC9d3Ch3oKQPjEAAYASAAEgLZAfD_BwE; device-id=device-YqpXu3mIM5-1636396372709; cdn-device-id=device-YqpXu3mIM5-1636396372709; image-type=webp; _gid=GA1.2.671842490.1636396375; _gat=1; _ym_isad=2; _ym_visorc=w; x-client-ip=94.181.152.227; _gat_gtag_UA_144858230_1=1; t=1jaf85tv54eus2csdmffjldq6k; cdnt=1jaf85tv54eus2csdmffjldq6k";
    public static String usersId = "f983d519-e243-4dd7-9b92-d0b00e165d8e";
    public static RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .addCookie(cookies)
            .setBaseUri(grinferURI)
            .setBasePath(grinferPATH)
            .setContentType(ContentType.JSON)
            .build();

}
