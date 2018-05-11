package cn.vworld.shiro;

import cn.vworld.utils.Md5HashPassword;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;



public class AuthCredential extends  SimpleCredentialsMatcher{
	
	
	//[a, d, m, i, n]
	//String password1 = Arrays.toString(loginToken.getPassword());
	//System.out.println(password1);
	
	//重新加密处理
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//将用户的明文进行加密处理
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		
		String username = loginToken.getUsername();
		//admin
		String password = String.valueOf(loginToken.getPassword()); 
		//将密码进行加密处理
		String md5password = Md5HashPassword.getMd5Hash(password, username);
		System.out.println(md5password);
		loginToken.setPassword(md5password.toCharArray());
		
		return super.doCredentialsMatch(loginToken, info);
	}
}
