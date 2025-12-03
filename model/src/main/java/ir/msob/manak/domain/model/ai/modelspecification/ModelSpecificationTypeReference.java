package ir.msob.manak.domain.model.ai.modelspecification;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.*;
import ir.msob.jima.core.commons.shared.PageResponse;
import ir.msob.manak.core.model.jima.channel.ChannelTypeReference;
import ir.msob.manak.core.model.jima.domain.DtoTypeReference;
import ir.msob.manak.core.model.jima.security.User;

import java.lang.reflect.Type;

public interface ModelSpecificationTypeReference
        extends DtoTypeReference<ModelSpecificationDto, ModelSpecificationCriteria>
        , ChannelTypeReference<ModelSpecificationDto, ModelSpecificationCriteria> {

    @Override
    default TypeReference<PageResponse<ModelSpecificationDto>> getPageResponseReferenceType() {
        return new TypeReference<PageResponse<ModelSpecificationDto>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ModelSpecificationCriteria> getCriteriaReferenceType() {
        return new TypeReference<ModelSpecificationCriteria>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ModelSpecificationDto> getDtoReferenceType() {
        return new TypeReference<ModelSpecificationDto>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, CriteriaMessage<String, ModelSpecificationCriteria>>> getChannelMessageCriteriaReferenceType() {
        return new TypeReference<ChannelMessage<User, CriteriaMessage<String, ModelSpecificationCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageableMessage<String, ModelSpecificationCriteria>>> getChannelMessagePageableReferenceType() {
        return new TypeReference<ChannelMessage<User, PageableMessage<String, ModelSpecificationCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageMessage<String, ModelSpecificationDto>>> getChannelMessagePageReferenceType() {
        return new TypeReference<ChannelMessage<User, PageMessage<String, ModelSpecificationDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, JsonPatchMessage<String, ModelSpecificationCriteria>>> getChannelMessageJsonPatchReferenceType() {
        return new TypeReference<ChannelMessage<User, JsonPatchMessage<String, ModelSpecificationCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtoMessage<String, ModelSpecificationDto>>> getChannelMessageDtoReferenceType() {
        return new TypeReference<ChannelMessage<User, DtoMessage<String, ModelSpecificationDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtosMessage<String, ModelSpecificationDto>>> getChannelMessageDtosReferenceType() {
        return new TypeReference<ChannelMessage<User, DtosMessage<String, ModelSpecificationDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }
}