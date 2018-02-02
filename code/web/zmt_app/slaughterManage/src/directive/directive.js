import { Toast } from 'mint-ui'
export const Msg = function (msg, wh = 'bottom' ,time = 2000) {
	return Toast({
				message: msg,
				position: wh,
				duration: time
			});
} 
import { Indicator } from 'mint-ui'
export const Load = function (msg) {
	return {
		open:Indicator.open({
			  text: msg,
			  spinnerType: 'fading-circle'
			 }),
		close: Indicator.close()
	}
} 