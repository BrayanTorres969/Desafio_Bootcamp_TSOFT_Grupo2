package proyecto.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

public class HotelPage extends BasePage {

    By byInputLugarAlojamiento = By.xpath("//input[@id=':Rjhl6lajldq2mm:']");
    By byOptionAndorra = By.xpath("//li[@id=':Rjhl6lajldq2mm:-option-0']");

    By byFechaIda = By.xpath("//div[@aria-labelledby='2-2024']//button[contains(text(),'18')]");
    By byFechaVuelta = By.xpath("//div[@aria-labelledby='2-2024']//button[contains(text(),'20')]");

    By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");

    By byBtnPrecios = By.xpath("//div[@id='Pill-PriceContainer']");
    By byDivPunteroMovil = By.xpath("//div[@data-testid='slider-bullet-right']");

    By byBtnAplicarFiltro = By.xpath("//button[contains(text(),'Aplicar')]");

    By byBtnLimpiarLugarAlojamiento = By.xpath("//div[@aria-label='Hoteles']//button[@aria-label='Limpiar']");
    By byInputLugarAlojamientoEsqui = By.xpath("//input[@id=':R4sd9lalamt2mm:']");
    By byOptionSierraNevada = By.xpath("//li[@id=':R4sd9lalamt2mm:-option-0']");

    By byFechaIdaEsqui = By.xpath("//div[@aria-labelledby='2-2024']//button[contains(text(),'18')]");
    By byFechaVueltaEsqui = By.xpath("//div[@aria-labelledby='3-2024']//button[contains(text(),'10')]");

    By byBtnTodosFiltros = By.xpath("//div[@id='Pill-AllFiltersContainer']");
    By byFiltroCancelacionGratis = By.xpath("//label[@id='ck_label_free_cancellation']");

    By byDivPrecioPunteroIzquierdoMovil = By.xpath("//div[@data-testid='slider-bullet-left']");
    By byDivMontoMinMaxPrecio = By.xpath("//div[@class='sc-dJiZtA BPFME oss-ui-slider-value-label']//div[@class='sc-epALIP hwCPgV oss-ui-slider-value-label']");
    By byLiHotelTipoAlojamiento = By.xpath("//li[@id='exp_elem_accomodation_type_1']//div[contains(text(),'Hotel')]");
    By byDivTituloEstrellas = By.xpath("//div[contains(text(),'Estrellas')]");
    By byLi4Estrellas = By.xpath("//li[@id='exp_elem_hotel_stars_4']//div[@class='listbox-label']");

    By byDivTituloRegimen = By.xpath("//div[contains(text(),'" + FixEncoding.corregirEncoding("Régimen") + "')]");
    By byDivSoloAlojamiento = By.xpath("//div[contains(text(),'Solo alojamiento')]");
    By byDivDesayuno = By.xpath("//div[contains(text(),'Desayuno') and contains(@class, 'sc-kCMKrZ bVFCNm')]");
    By byDivPensionCompleta = By.xpath("//div[contains(text(),'" + FixEncoding.corregirEncoding("Pensión completa") + "')]");

    By byDivTituloValoracion = By.xpath("//div[contains(text(),'" + FixEncoding.corregirEncoding("Valoración") + "')]");
    By byDivValoracionExcelente = By.xpath("//div[contains(text(),'87+')]");

    By byDivTituloServicios = By.xpath("//div[contains(text(),'Servicios')]");
    By byDivWifiGratis = By.xpath("//div[contains(text(),'Wifi gratis') and contains(@class, 'listbox-label')]");
    By byDivParking = By.xpath("//div[contains(text(),'Parking') and contains(@class, 'listbox-label')]");
    By byDivSpa = By.xpath("//li[@id='exp_elem_general_accomodation_facilities_6']//div[contains(text(),'Spa') and contains(@class, 'listbox-label')]");
    By byDivInstalacionesFitness = By.xpath("//div[contains(text(),'Instalaciones para fitness') and contains(@class, 'listbox-label')]");

    By byDivAplicarTodosFiltros = By.xpath("//div[contains(text(),'Aplicar')]");

    public HotelPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarPrimerosDatos(String texto){
        clic(esperarElementoWeb(byInputLugarAlojamiento));
        agregarTexto(byInputLugarAlojamiento, texto);
        esperarXsegundos(getTiempoCortoEspera());
        clic(esperarElementoWeb(byOptionAndorra));
        esperarXsegundos(getTiempoCortoEspera());
        clic(esperarElementoWeb(byFechaIda));
        clic(esperarElementoWeb(byFechaVuelta));
        clic(buscarElementosWeb(byBtnBuscar).get(0));
    }

    public void filtrarPrecio(String resultadoFinalEsperado){
        clic(esperarElementoWeb(byBtnPrecios));
        esperarXsegundos(getTiempoCortoEspera());
        agarrarArrastrarPuntero_RangoPrecios(byDivPunteroMovil,byDivMontoMinMaxPrecio, 1, "200", -1);
        validarMensajeSinFixEncoding("Max.\n200 \u20ac", buscarElementosWeb(byDivMontoMinMaxPrecio).get(1));
        clic(esperarElementoWeb(byBtnAplicarFiltro));
        esperarXsegundos(getTiempoLargoEspera());
        validarMensaje(resultadoFinalEsperado, esperarElementoWeb(By.xpath("//span[contains(text(),'" + resultadoFinalEsperado + "')]")));
    }

    public void agregarDatosEsqui(String texto){
        clic(esperarElementoWeb(byBtnLimpiarLugarAlojamiento));
        agregarTexto(byInputLugarAlojamientoEsqui, texto);
        esperarXsegundos(getTiempoCortoEspera());
        clic(esperarElementoWeb(byOptionSierraNevada));
        esperarXsegundos(getTiempoCortoEspera());
        clic(esperarElementoWeb(byFechaIdaEsqui));
        clic(esperarElementoWeb(byFechaVueltaEsqui));
        clic(buscarElementosWeb(byBtnBuscar).get(0));
    }

    public void filtrarVariosDatos(String resultadoFinalEsperado){
        clic(esperarElementoWeb(byBtnTodosFiltros));
        esperarXsegundos(getTiempoMedioEspera());

        clic(esperarElementoWeb(byFiltroCancelacionGratis));
        esperarXsegundos(getTiempoMedioEspera());

        agarrarArrastrarPuntero_RangoPrecios(byDivPrecioPunteroIzquierdoMovil,byDivMontoMinMaxPrecio, 0, "1700", 1);
        validarMensajeSinFixEncoding("Min.\n1700 \u20ac", buscarElementosWeb(byDivMontoMinMaxPrecio).get(0));
        esperarXsegundos(getTiempoMedioEspera());

        buscarYClick(byLiHotelTipoAlojamiento, byLiHotelTipoAlojamiento);
        buscarYClick(byLi4Estrellas, byDivTituloEstrellas);
        buscarYClick(byDivSoloAlojamiento, byDivTituloRegimen);
        buscarYClick(byDivDesayuno, byDivTituloRegimen);
        buscarYClick(byDivPensionCompleta, byDivTituloRegimen);
        buscarYClick(byDivValoracionExcelente, byDivTituloValoracion);
        buscarYClick(byDivWifiGratis, byDivTituloServicios);
        buscarYClick(byDivParking, byDivTituloServicios);
        buscarYClick(byDivSpa, byDivTituloServicios);
        buscarYClick(byDivInstalacionesFitness, byDivTituloServicios);
        clic(esperarElementoWeb(byDivAplicarTodosFiltros));
        esperarXsegundos(getTiempoLargoEspera());
        validarMensaje(resultadoFinalEsperado, esperarElementoWeb(By.xpath("//span[contains(text(),'" + resultadoFinalEsperado + "')]")));
    }

    //T015_Busqueda_HotelesCasa_RangoPrecios
    public void ejecutador_T015(String lugarAlojamiento, String resultadoFinalEsperado){
        ingresarPrimerosDatos(lugarAlojamiento);
        esperarXsegundos(getTiempoLargoEspera());
        filtrarPrecio(resultadoFinalEsperado);
    }

    //T017_Busqueda_HotelesEsqui_VariosFiltrosDeUna
    public void ejecutador_T017(String lugarAlojamiento, String resultadoFinalEsperado){
        agregarDatosEsqui(lugarAlojamiento);
        esperarXsegundos(getTiempoMedioEspera());
        filtrarVariosDatos(resultadoFinalEsperado);
    }
}
