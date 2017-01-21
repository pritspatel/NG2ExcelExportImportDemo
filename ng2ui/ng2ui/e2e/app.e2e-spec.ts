import { Ng2uiPage } from './app.po';

describe('ng2ui App', function() {
  let page: Ng2uiPage;

  beforeEach(() => {
    page = new Ng2uiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
