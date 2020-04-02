import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { throwError, Subject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { JwtHelperService } from "@auth0/angular-jwt";
import { ITokenDetail } from 'projects/fast-code-core/src/public_api';

const API_URL = environment.apiUrl;

const helper = new JwtHelperService();

@Injectable()
export class AuthenticationService {
  private decodedToken: ITokenDetail;
  permissionsChange: Subject<string> = new Subject<string>();
  private apiUrl = API_URL;// 'http://localhost:5555';
  private _reqOptionsArgs = {
    withCredentials: true,
    headers: new HttpHeaders().set('Content-Type', 'application/json').append('Access-Control-Allow-Origin', '*')
  };

  constructor(
    private http: HttpClient
  ) {
  }

  login(user: any): Observable<any> {
    return this.http.post<any>(this.apiUrl + '/login', user, this._reqOptionsArgs).pipe(map(res => {
      let retval = res;
      localStorage.setItem("salt", retval.salt);
      localStorage.setItem("token", retval.token);
      this.decodedToken = null;
      this.decodeToken();
      return retval;
    }));
  }

  logout(){
    this.http.post<any>(this.apiUrl + '/auth/logout', null, this._reqOptionsArgs).subscribe(result => {
    })
    localStorage.removeItem('token');
  }

  get token(): string {
    return !localStorage.getItem("token") ? null : localStorage.getItem("token");
  }

  decodeToken(): ITokenDetail {
    if (this.decodedToken) {
      return this.decodedToken;
    }
    else {
      if (this.token) {
        let decodedToken: ITokenDetail = helper.decodeToken(this.token) as ITokenDetail;
        this.decodedToken = decodedToken;
        return this.decodedToken;
      }
      else {
        return null;
      }
    }
  }

  getTokenExpirationDate(): Date {
    const decoded = helper.decodeToken(this.token);

    if (decoded.exp === undefined) {
      return null;
    }

    const date = new Date(0);
    date.setUTCSeconds(decoded.exp);
    return date;
  }

  isTokenExpired(token?: string): boolean {
    if (!token) {
      token = this.token;
      return true;
    }

    const date = this.getTokenExpirationDate();
    if (date === undefined) {
      return false;
    }
    return !(date.valueOf() > new Date().valueOf());
  }

  private handleError(err: HttpErrorResponse) {

    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

}