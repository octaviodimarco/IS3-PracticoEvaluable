exports.config = {
	tests: "./*_test.js",
	output: "./output",
	helpers: {
		REST: {
			endpoint: "http://localhost:8080",
			onRequest: () => {
			}
		}
	},
	include: {},
	bootstrap: null,
	mocha:  {
      "reporterOptions": {
        "codeceptjs-cli-reporter": {
          "stdout": "-",
          "options": {
            "steps": true,
          }
        },
        "mocha-junit-reporter": {
          "stdout": "./output/console.log",
          "options": {
            "mochaFile": "./output/result.xml"
          },
          "attachments": true //add screenshot for a failed test
        }
      }
  

  },
	name: "codeceptjs-rest"
};