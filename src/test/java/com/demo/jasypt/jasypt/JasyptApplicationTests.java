package com.demo.jasypt.jasypt;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class JasyptApplicationTests {
	@Autowired
	private StringEncryptor jasyptStringEncryptor;

	@Test
	void contextLoads() {
	}

	@Test
	public void testEncrypt(){
		String target_text = "theValueYouWantToEncrypt";

		String enc_text = jasyptStringEncryptor.encrypt(target_text);
		log.info(enc_text);

		String decText = jasyptStringEncryptor.decrypt(enc_text);
		Assertions.assertThat(decText).isEqualTo(target_text);
	}

}
