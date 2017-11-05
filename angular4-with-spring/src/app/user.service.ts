import { Injectable } from '@angular/core';

import {HttpClient, HttpHeaders} from "@angular/common/http";
import 'rxjs/add/operator/toPromise';

import { User } from './user'

@Injectable()
export class UserService {

  private userUrl = '/rest/user/hello?name=Innova';

  constructor(private http: HttpClient){}
  
  getHelloMsg(): Promise<User> {
    return this.http.get(this.userUrl)
      .toPromise()
      .then(response => response as User)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }
}
