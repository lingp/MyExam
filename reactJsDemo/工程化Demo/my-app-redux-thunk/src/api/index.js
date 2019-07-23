import ajax from './ajax'

// 1.定义基础路径
const BASE_URL = '/reactApiDemo';

// 2. 请求list数据
export const getDatas = () => ajax(BASE_URL + '/getListData.php');


