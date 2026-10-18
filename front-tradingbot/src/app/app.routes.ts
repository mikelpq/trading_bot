import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import {CoinComponent} from './coin/coin.component';

export const routes: Routes = [
  {
    path: '',
    component: DashboardComponent
  },
  {
    path: 'coin',
    component: CoinComponent
  }

];
