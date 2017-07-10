Explicación conceptos propios de cuentas de crédito:

* *cutoffDate*: Próxima fecha de corte.
* *grantedCredits*: Crédito concedido a la cuenta. Este valor no cambia a lo largo del tiempo (salvo renegociación o ampliación).
* *availabieBalance* (sin entrar en los balances interiores): Cantidad que puedo gastar del crédito concedido.
* *disposedBalance* (sin entrar en los balances interiores): Cantidad que llevo gastada del crédito concedido (sería mi deuda total).
** La fórmula grantedCredits = availableBalance + disposedBalance se cumple en todo momento.
* *paymentMethod*: Configuración del método de pago de la deuda de crédito en base a la deuda total de la última fecha de corte. Incluye:
** *paymentType*: Tipo de cantidad en base a la deuda total a la fecha de corte a pagará en cada plazo.
** *period*: Periodicidad de pago.
** *monetaryPayments*: Cantidad de la deuda total existente a la última fecha de corte a pagar antes de la fecha límite de pago. (endDate).
** *percentage*: Porcentaje de la  deuda total existente a la última fecha de corte a pagar antes de la fecha límite de pago (endDate).
** *endDate*: Fecha límite de pago del plazo referente a la última fecha de corte.
** *paymentAmounts*: Cantidades de referencia de pago de la deuda calculados en base a la deuda total en la última fecha de corte. El significado de cada uno de los posibles tipos es:
*** *MINIMUM_AMOUNT*: Cantidad mínima a pagar antes de la fecha límite de pago (endDate) para no entrar en mora.
*** *MINIMUM_AMOUNT_TO_AVOID_INTEREST*: Cantidad mínima a pagar antes de la fecha límite de pago (endDate) para que la deuda no genere intereses.
*** *TOTAL_DEBT_AMOUNT*: Deuda total existente a la última fecha de corte. Coincidiría con el valor de *disposedBalance.currentBalances* al final del día de la última fecha de corte.
*** *LAST_PERIOD_AMOUNT* {color:red}nuevo{color}: Gastos realizados en el último periodo, incluyendo las cuotas de pagos financiados satisfechas durante dicho periodo.

Ejemplo:

Periodos de 1 mes
Fecha de corte: todos los días 28
Fecha de pago: día 5 del mes siguiente a la fecha de corte
Crédito concedido: 3.000 €

Durante el primer periodo:
	Vísta a día 2016-08-07 (no hay gasto alguno):
		cutoffDate: 2016-08-28
		grantedCredits: 3.000 €
		availableBalance: 3.000 €
		disposedBalance: 0 €
		paymentMethod:
			paymentType: MINIMUN
			period: MONTHLY
			monetaryPayments: (sin valor)
			endDate: (sin valor)
			paymentAmounts: (sin valor)

	Vísta a día 2016-08-28 (fecha de corte) (gasto de 500€):
		cutoffDate: 2016-08-28
		grantedCredits: 3.000 €
		availableBalance: 2.500 €
		disposedBalance: 500 €
		paymentMethod:
			paymentType: MINIMUM_AMOUNT_TO_AVOID_INTEREST_PAYMENT
			period: MONTHLY
			monetaryPayments: (sin valor)
			endDate: (sin valor)
			paymentAmounts: (sin valor)

Durante el segundo periodo:
	Vista 2016-08-29 (primer día) (no hay gasto alguno en este periodo):
		cutoffDate: 2016-09-28
		grantedCredits: 3.000 €
		availableBalance: 2.500 €
		disposedBalance: 500 €
		paymentMethod:
			paymentType: MINIMUM_AMOUNT_TO_AVOID_INTEREST_PAYMENT
			period: MONTHLY
			monetaryPayments: 300 €
			endDate: 2016-09-05
			paymentAmounts:
				Para id: MINIMUM_AMOUNT
					values: 100 €
				Para id: MINIMUM_AMOUNT_TO_AVOID_INTEREST
					values: 300 €
				Para id: TOTAL_DEBT_AMOUNT
					values: 500 €
				Para id: LAST_PERIOD_AMOUNT
					values: 500 €

	Vista día 2016-09-03 (antes del pago) (se ha hecho un gasto de 100 € en este periodo):
		cutoffDate: 2016-09-28
		grantedCredits: 3.000 €
		availableBalance: 2.400 €
		disposedBalance: 600 €
		paymentMethod:
			paymentType: MINIMUM_AMOUNT_TO_AVOID_INTEREST_PAYMENT
			period: MONTHLY
			monetaryPayments: 300 €
			endDate: 2016-09-05
			paymentAmounts:
				Para id: MINIMUM_AMOUNT
					values: 100 €
				Para id: MINIMUM_AMOUNT_TO_AVOID_INTEREST
					values: 300 €
				Para id: TOTAL_DEBT_AMOUNT
					values: 500 €
				Para id: LAST_PERIOD_AMOUNT
					values: 500 €

	Vista a día 2016-09-05 (fecha de pago) (se ha hecho un gasto de 100€ en este periodo y se satisface el pago configurado):
		cutoffDate: 2016-09-28
		grantedCredits: 3.000 €
		availableBalance: 2.700 €
		disposedBalance: 300 €
		paymentMethod:
			paymentType: MINIMUM_AMOUNT_TO_AVOID_INTEREST_PAYMENT
			period: MONTHLY
			monetaryPayments: (sin valor)
			endDate: (sin valor)
			paymentAmounts: (sin valor)

	Vista a día 2016-09-28 (fecha de corte) (se ha hecho un gasto de 1050€ en este periodo):
		cutoffDate: 2016-09-28
		grantedCredits: 3.000 €
		availableBalance: 1.650 €
		disposedBalance: 1.350 €
		paymentMethod:
			paymentType: MINIMUM_AMOUNT_TO_AVOID_INTEREST_PAYMENT
			period: MONTHLY
			monetaryPayments: (sin valor)
			endDate: (sin valor)
			paymentAmounts: (sin valor)

Durante tercer periodo:
	Vista 2016-09-29 (primer día) (no hay gasto alguno en este periodo):
		cutoffDate: 2016-09-28
		grantedCredits: 3.000 €
		availableBalance: 1.650 €
		disposedBalance: 1.350 €
		paymentMethod:
			paymentType: MINIMUM_AMOUNT_TO_AVOID_INTEREST_PAYMENT
			period: MONTHLY
			monetaryPayments: 820 €
			endDate: 2016-10-05
			paymentAmounts:
				Para id: MINIMUM_AMOUNT
					values: 300 €
				Para id: MINIMUM_AMOUNT_TO_AVOID_INTEREST
					values: 820 €
				Para id: TOTAL_DEBT_AMOUNT
					values: 1.350 €
				Para id: LAST_PERIOD_AMOUNT
					values: 1050 €
