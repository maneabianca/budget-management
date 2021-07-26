import {ICategory} from './category';
import {IAccount} from './account';

export interface ITransaction {
  id: number;
  transactionDate: string;
  description?: string;
  value: number;
  categoryDto: ICategory;
  accountDto: IAccount;
}
// export class TransactionClass implements ITransaction {
//   id: number;
//   transactionDate: string;
//   description: string;
//   value: number;
//   categoryDto: Category;
//   accountDto: Account;
// }
