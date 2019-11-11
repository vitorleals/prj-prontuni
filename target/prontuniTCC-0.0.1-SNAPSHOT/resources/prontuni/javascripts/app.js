$(function() {
	$('.js-toggle').bind('click', function(event) {
		$('.js-sidebar, .js-content').toggleClass('is-toggled');
		event.preventDefault();
	});	
});


var offset = $('#menu').offset().top;
var $menu = $('#menu'); // guardar o elemento na memoria para melhorar performance
$(document).on('scroll', function () {
    if (offset <= $(window).scrollTop()) {
        $menu.addClass('fixar');
    } else {
        $menu.removeClass('fixar');
    }
});


PrimeFaces.locales['pt'] = {
            closeText: 'Fechar',
            prevText: 'Anterior',
            nextText: 'Próximo',
            currentText: 'Começo',
            monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
            monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Des'],
            dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
            dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],
            dayNamesMin: ['D','S','T','Q','Q','S','S'],
            weekHeader: 'Semana',
            firstDay: 1,
            isRTL: false,
            showMonthAfterYear: false,
            yearSuffix: '',
            timeOnlyTitle: 'Só Horas',
            timeText: 'Tempo',
            hourText: 'Hora',
            minuteText: 'Minuto',
            secondText: 'Segundo',
            currentText: 'Data Atual',
            ampm: false,
            month: 'Mês',
            week: 'Semana',
            day: 'Dia',
            allDayText : 'Todo Dia'
            
 
        };

function skinRadarChart() {
    Chart.defaults.global.startAngle = 36;
    Chart.defaults.global.tooltips.cornerRadius = 3;
    Chart.defaults.global.tooltips.enabled = true;
    Chart.defaults.global.tooltips.mode = 'point';
    Chart.defaults.global.tooltips.position = 'nearest';
}


