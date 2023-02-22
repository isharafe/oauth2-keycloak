import { Component, OnDestroy } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { AppService } from './app.service';
import { authConfig } from './auth.config';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
  title = 'keycloak-pkce-demo';
  text = '';
  helloSubscription ?: Subscription;

  constructor(
    private oauthService: OAuthService,
    private appService: AppService
  ) {
    this.configure();
  }

  private configure() {
    this.oauthService.configure(authConfig);
    this.oauthService.loadDiscoveryDocumentAndLogin();
  }

  login() {
    this.oauthService.initCodeFlow();
  }

  logout() {
    this.oauthService.logOut();
  }

  loadData() : void {
    this.helloSubscription = this.appService.hello().subscribe(data => {
      this.text = data;
    });
  }

  ngOnDestroy(): void {
    this.helloSubscription?.unsubscribe();
  }

}
