import {IUser} from './user';

export interface ICategory {
  id: number;
  name: string;
  type: string[];
  userDto: IUser;
}
// export class Category implements ICategory {
//   id: number;
//   name: string;
//   type: string[];
//   userDto: User;
// }
