
				$(document).ready(function() {

					steps.main();

					formValidate.main();

				});

				var formValidate = (function() {
					//Private variables
					//Button var
					var buttonConclude = ".btn-conclude";
					//Content var
					var stepContent = ".step-content";
					var result = "#result";
					var menuSteps = ".menu-steps";
					//Form var
					var formConclude = "form#form-conclude";
					var formValueCheck = "input#check-validate";
					var formValueIncome = "input#income";
					var formValuePatrimony = "input#patrimony";
					//Private variables

					return {
						main : function() {
							$("form#form-conclude")
									.find(formValueCheck)
									.click(
											function(event) {
												formValidate
														.validateFormConclude(
																$(this)
																		.closest(
																				formConclude)
																		.find(
																				formValueCheck),
																$(this)
																		.closest(
																				formConclude)
																		.find(
																				formValueIncome)
																		.val(),
																$(this)
																		.closest(
																				formConclude)
																		.find(
																				formValuePatrimony)
																		.val());
											});

							$("form#form-conclude").find(buttonConclude).click(
									function() {
										formValidate.concludeForm($(
												formConclude).find(
												formValueCheck),
												$(formConclude).find(
														formValueIncome).val(),
												$(formConclude).find(
														formValuePatrimony)
														.val());
									});
						},//end - main

						concludeForm : function(check, income, patrimony) {
							$(stepContent).removeClass("active");
							$(result).addClass("active");
							$(menuSteps).addClass("none");

							$("input#income-value").attr("placeholder", income);
							$("input#patrimony-value").attr("placeholder",
									patrimony);
						},//end - concludeForm

						validateFormConclude : function(check, income,
								patrimony) {
							if (check.attr("checked") && income !== ""
									&& patrimony !== "") {
								$(buttonConclude).removeAttr("disabled");
							} else {
								$(buttonConclude).attr("disabled", "disabled");
							}
						}, //end - validateFormConclude

					}//end - return

				})();

				var steps = (function() {
					//Private variables
					//Button var
					var buttonConclude = ".btn-conclude";
					var buttonNext = ".btn-next";
					var buttonBack = ".btn-back";

					//Content var
					var stepContent = ".step-content";
					var conclude = "#conclude";
					
					//Private variables

					return {
						main : function() {
							//Click validação input radio
							$(".step-content form input[type='radio']")
									.click(
											function(event) {
												steps
														.validationClickNextStep(
																$(this),
																$(this)
																		.parents(
																				"form")
																		.find(
																				buttonNext),
																$(this)
																		.parents(
																				"form")
																		.find(
																				buttonConclude));
											});

							//Click voltar opção
							$(".step-content form .btn-back").click(
									function(event) {
										steps.moveStep($(this).closest(
												stepContent).attr("id"),
												$(this).attr("class"), steps
														.totalsteps());
									});//end - btn-back

							//Click próxima pergunta
							$(".step-content form .btn-next").click(
									function(event) {
										steps.moveStep($(this).closest(
												stepContent).attr("id"),
												$(this).attr("class"), steps
														.totalsteps());
									});//end - btn-next
						}, //end - main

						//Validação próximo passo que recebe como parametros o elemento radio atual, a classNext e a classConclude
						validationClickNextStep : function(thisElement,
								classNext, classConclude) {
							if (classNext.length > 0) {
								thisElement.parents("form").find(buttonNext)
										.removeAttr("disabled");
							} else if (classConclude.length > 0) {
								thisElement.parents("form")
										.find(buttonConclude).removeAttr(
												"disabled");
							}
						},//end - validationClickNextStep

						//Método que recebe o nome do passo, o tipo se é next ou back, e o array com todos os passo
						moveStep : function(nameStep, typeMove, arrSteps) {
							for (var i = 0; i < arrSteps.length; i++) {
								if (arrSteps[i] === nameStep
										&& typeMove === "btn-next") {
									$("#" + arrSteps[i]).removeClass("active");
									i += 1;
									$("#" + arrSteps[i]).addClass("active");
									$("." + arrSteps[i])
											.addClass("active-menu");
								} else if (arrSteps[i] === nameStep
										&& typeMove === "btn-back") {
									$("#" + arrSteps[i]).removeClass("active");
									$("." + arrSteps[i]).removeClass(
											"active-menu");
									i -= 1;
									$("#" + arrSteps[i]).addClass("active");
									$("." + arrSteps[i])
											.addClass("active-menu");
									return;
								} else if (typeMove === "btn-conclude") {
									$(stepContent).removeClass("active");
									$(conclude).addClass("active");
								}
							}//end - for

						}, //end - moveStep

						//Faz a contagem de todos os passo existentes
						totalsteps : function() {
							var arrQuestions = [];
							$(stepContent).each(function(index, el) {
								arrQuestions[index] = $(this).attr("id");
							});
							return arrQuestions;
						}//end - totalsteps

					}//end - return

				})();
		

			
		
				$(document).ready(function() {
					$(".card").click(function() {
						$("#card2").hide();
					});
					$(".card").click(function() {
						$("#card2").show();
					});
				});
		

		
				function pop() {
					alert("인증번호가 전송되었습니다.");
					return false;
				}
		
