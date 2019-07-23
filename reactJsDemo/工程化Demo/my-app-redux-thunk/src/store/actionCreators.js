import {GET_ALL_DATAS, CHANGE_FINISHED, DEL_ONE} from './actionTypes'
import {getDatas} from "../api";

// 1.获取所有记录
export const getAllDatas = (datas) => ({
    type: GET_ALL_DATAS,
    datas: datas
});

export const initDatas = ()=>{
    return (dispatch) => {
        getDatas().then((res)=>{
            if(res.success_code  === 200){
                const action = getAllDatas(res.items);
                dispatch(action);
            }
        })
    }
};

// 修改选中状态
export const changeFinished = (id, isFinished) => ({
    type: CHANGE_FINISHED,
    id:id,
    isFinished
});

// 删除一条记录
export const delOne = (id) => ({
   type: DEL_ONE,
   id:id
});