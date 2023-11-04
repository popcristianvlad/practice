import {browser, by, element, logging} from 'protractor';

describe('sample-angular-first-app-tutorial-angular-homes app', () => {

    beforeEach(() => browser.get(''));

    it('should display correct title', async () => {
        expect(await element.all(by.css('h1')).get(0).getText()).toEqual('Default');
    });

    afterEach(async () => {
        // Assert that there are no errors emitted from the browser
        const logs = await browser.manage().logs().get(logging.Type.BROWSER);
        expect(logs).not.toContain(jasmine.objectContaining({
            level: logging.Level.SEVERE,
        } as logging.Entry));
    });
});
