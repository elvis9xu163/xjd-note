function changeLanguage(lang) {
	$("#language_select_form input:first-child").val(lang);
	$("#language_select_form").submit();
}