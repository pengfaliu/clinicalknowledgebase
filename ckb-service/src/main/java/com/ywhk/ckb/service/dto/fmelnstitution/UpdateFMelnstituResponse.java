package com.ywhk.ckb.service.dto.fmelnstitution;import com.fasterxml.jackson.annotation.JsonIgnoreProperties;import lombok.Data;import java.io.Serializable;@Data@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })public class UpdateFMelnstituResponse implements Serializable {}