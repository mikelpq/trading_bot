import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Coin } from "../model/coin";
import { Observable } from "rxjs";


@Injectable({providedIn: 'root'})
export class CoinService {
    private readonly http = inject(HttpClient);
    private readonly url = "http://localhost:8080/tb"; //document.location.toString()


    public getCoin(coin : string) {
        return this.http.get<Coin>(this.url + '/coin/getCoin/' + coin + '/EUR');
    }

    public getAllCoins() : Observable<Coin[]> {
        return this.http.get<Coin[]>(this.url + '/coin/getAllCoins');
    }

    
}
