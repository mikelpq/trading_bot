import { Component } from '@angular/core';
import {ActivatedRoute, Route} from '@angular/router';
import {Coin} from '../model/coin';
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from '@angular/material/card';

@Component({
  selector: 'app-coin',
  imports: [
    MatCard,
    MatCardHeader,
    MatCardTitle,
    MatCardContent
  ],
  templateUrl: './coin.component.html',
  styleUrl: './coin.component.sass',
})
export class CoinComponent {

  protected coin : Coin | null = null;

  constructor(private readonly route: ActivatedRoute) {

    this.coin = {
      oid: 0,
      version: 0,
      name: this.route.snapshot.params['name'],
      symbol: this.route.snapshot.params['symbol'],
      currency: this.route.snapshot.params['currency'],
      sellPrice: this.route.snapshot.params['sellPrice'],
      buyPrice: this.route.snapshot.params['buyPrice'],
      spotPrice: this.route.snapshot.params['spotPrice']
    };
  }

}
