function SomenteNumero() {
	if (event.keyCode < 48 || event.keyCode > 57) {
		return false;
	}
}

jQuery(function($) {
	$("#form_requerente\\:cpf").mask("999.999.999-99");
	$("#form_requerente\\:telefone").mask("(99) 9999-9999");
	$("#form_requerente\\:cep").mask("99999-999");
});