
import axios from "../utils/axios";

const ComAPI = class{
    get( url, params ){
        return axios({url,params
        }).then(res => {
            return res;
        }).catch(err =>{
            return err;
        })
    }
    
    post( url, data ){
        return axios({url,data, method:'post'
        }).then(res => {
            return res;
        }).catch(err =>{
            return err;
        })
    }
}

export default new ComAPI





