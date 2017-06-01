card_class = {
	'left': 'card_item',
	'right': 'card_item_right'
};

function create_card_item(params, card_direction) {
	content = $(".hist_content");
	
	card_item = document.createElement('div');
	$(card_item).addClass(card_class[card_direction]).appendTo(content);
	
	card_interior = document.createElement('div');
	$(card_interior).addClass('card_interior').appendTo(card_item);

	card_titulo = document.createElement('h3');
	$(card_titulo).addClass('card_titulo').text(params['titulo']).appendTo(card_interior);

	card_desativ = document.createElement('h4');
	$(card_desativ).addClass('card_subtitulo').text(params['desativado_em']).appendTo(card_interior);

	card_texto = document.createElement('div');
	$(card_texto).addClass('card_texto').appendTo(card_interior);

	paragrafo = document.createElement('p');
	$(paragrafo).text(params['texto']).appendTo(card_texto);

	adesao_valor = document.createElement('h1');
	$(adesao_valor).addClass('card_valor').text(params['valor']).appendTo(card_interior);

	appendLink($(card_interior), params);

}

function appendLink(div, params){
	btn = document.createElement('div');
	$(btn).addClass('card_btn').appendTo(div);

	link = document.createElement('a');
	$(link).attr('href', '#').appendTo(btn);

	link_texto = document.createElement('span');
	$(link_texto).text(params['btn_texto']).appendTo(link);
}