import { Message } from 'element-ui'
export const msg = function(ms,them,pos){
	return Message({
		message:ms,
		customClass:pos,
		type:them
	})
}