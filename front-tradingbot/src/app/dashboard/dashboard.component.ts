import { AfterViewInit, ChangeDetectionStrategy, Component, ViewChild } from '@angular/core';
import { Coin } from '../model/coin';
import { CoinService } from '../service/coin.service';
import { BehaviorSubject, Subscription } from 'rxjs';
import { MatCardModule } from '@angular/material/card';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import {Router} from '@angular/router';

@Component({
  selector: 'app-dashboard',
  imports: [
    MatCardModule,
    MatTableModule,
    MatPaginator
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.sass',
  changeDetection: ChangeDetectionStrategy.Eager
})
export class DashboardComponent implements AfterViewInit {
  protected displayedColumns: string[] = ['symbol', 'name'];
  protected allCoins: BehaviorSubject<Coin[]> = new BehaviorSubject<Coin[]>([]);
  protected dataSource = new MatTableDataSource<Coin>([]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private readonly coinService: CoinService,
              private readonly router: Router){

    this.coinService.getAllCoins().subscribe(values => this.allCoins.next(values));

    this.allCoins.subscribe(coins => {
      this.dataSource.data = coins;
    })
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  protected onRowClick(row: Coin) {
    this.coinService.getCoin(row.symbol!).subscribe(coin => {
      this.router.navigate(['/coin', coin])
    });
  }
}
