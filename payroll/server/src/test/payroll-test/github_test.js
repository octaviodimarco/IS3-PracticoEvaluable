const expect = require('chai').expect;
const {I} = inject();

Feature('Payroll');

Scenario('Verificar a successful call', async () => {
	const res = await I.sendGetRequest('/employees');
	expect(res.status).to.eql(200);
});

Scenario('Verificar empleado 1', async () => {
	const res = await I.sendGetRequest('/employees/1');
	//console.log(res);
	expect(res.data.firstName).to.eql('Bilbo');
	expect(res.data.lastName).to.eql('Baggins');
});