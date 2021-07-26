import {ICurrency} from './currency';
import {IUser} from './user';

export interface IAccount {
  id: number;
  name: string;
  currentBalance: number;
  currencyDto: ICurrency;
  userDto: IUser;
}
// export class Account implements IAccount {
//   id: number;
//   name: string;
//   currentBalance: number;
//   currencyDto: Currency;
//   userDto: User;
// }
